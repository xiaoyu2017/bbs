function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        let r = Math.random() * 16 | 0,
            v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
    })
}

const data = []

function users() {
    for (let i = 0; i < 9; i++) {
        data.push({
            uid: 'user' + i,
            userName: 'userName' + i,
            nickName: 'nickName' + i,
            email: 'email' + i + '@gmail.com',
            phone: '1889999000' + i,
            qq: '998877660' + i,
        })
    }
    return data;
}

const mockData = {
    'GET /v1/api/user': users(),
    'POST /v1/api/user': (req, res) => {
        const {userName, nickName, email, phone, qq} = req.body;
        data.push({
            uid: guid(), userName: userName, nickName: nickName, email: email, phone: phone, qq: qq
        })
        return res.json({
            error: 0,
            message: 'add success!'
        });
    },
    'PUT /v1/api/user': (req, res) => {
        const {uid, userName, nickName, email, phone, qq} = req.body;
        const getData = {uid: uid, userName: userName, nickName: nickName, email: email, phone: phone, qq: qq}
        for (let i = 0; i < data.length; i++) {
            if (uid === data[i].uid) {
                data[i] = getData
            }
        }
        res.send({error: 0, message: 'update success！'});
    },
    'DELETE /v1/api/user/:uid': (req, res) => {
        const uid = req.params.uid
        for (let i = 0; i < data.length; i++) {
            if (uid === data[i].uid) {
                data.splice(i, i + 1)
            }
        }
        res.send({status: 'ok', message: 'delete success!'})
    },
}

module.exports = mockData
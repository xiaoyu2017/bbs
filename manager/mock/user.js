const baseData = require('./BaseData')

const mockData = {
    'GET /v1/api/user': (req, res) => {
        return res.json({
            error: 0,
            message: 'get user success!',
            data: baseData.getUsersByPage(Number(req.query.page), Number(req.query.num))
        })
    },
    'POST /v1/api/user': (req, res) => {
        const {userName, nickName, email, phone, qq} = req.body;
        baseData.addUser({
            userName: userName, nickName: nickName, email: email, phone: phone, qq: qq
        })
        return res.json({
            error: 0,
            message: 'add success!'
        });
    },
    'PUT /v1/api/user': (req, res) => {
        const {uid, userName, nickName, email, phone, qq} = req.body;
        const updateData = {uid: uid, userName: userName, nickName: nickName, email: email, phone: phone, qq: qq}
        baseData.updateUser(updateData)
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
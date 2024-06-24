const userData = require('./UserData')

const mockData = {
    'GET /v1/api/user': (req, res) => {
        console.log('UserArrayLength:' + userData.data.length)
        return res.json({
            error: 0,
            message: 'get user success!',
            data: userData.getUsersByPage(Number(req.query.page), Number(req.query.num)),
            total:userData.data.length
        })
    },
    'POST /v1/api/user': (req, res) => {
        const {userName, nickName, email, phone, qq} = req.body;
        userData.addUser({
            userName: userName, nickName: nickName, email: email, phone: phone, qq: qq
        })
        console.log('UserArrayLength:' + userData.data.length)
        return res.json({
            error: 0,
            message: 'add success!'
        });
    },
    'PUT /v1/api/user': (req, res) => {
        const {uid, userName, nickName, email, phone, qq} = req.body;
        const updateData = {uid: uid, userName: userName, nickName: nickName, email: email, phone: phone, qq: qq}
        userData.updateUser(updateData)
        res.send({error: 0, message: 'update success！'});
    },
    'DELETE /v1/api/user/:uid': (req, res) => {
        const uid = req.params.uid
        userData.deleteUser(uid)
        console.log('UserArrayLength:' + userData.data.length)
        res.send({status: 'ok', message: 'delete success!'})
    },
}

module.exports = mockData
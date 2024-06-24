function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function (c) {
        let r = Math.random() * 16 | 0,
            v = c === 'x' ? r : (r & 0x3 | 0x8)
        return v.toString(16)
    })
}

function initUsersData() {
    let data = []
    for (let i = 0; i < 47; i++) {
        data.push({
            uid: guid(),
            userName: 'userName' + i,
            nickName: 'nickName' + i,
            email: 'email' + i + '@gmail.com',
            phone: '1889999000' + i,
            qq: '998877660' + i,
        })
    }
    return data
}

let ResponseEntity = {
    data: initUsersData(),
    addUser: function (user) {
        user.uid = guid()
        this.data.push(user)
    },
    deleteUser: function (uid) {
        for (let i = 0; i < this.data.length; i++) {
            if (uid === this.data[i].uid) {
                this.data.splice(i, 1)
            }
        }
    },
    updateUser: function (user) {
        for (let i = 0; i < this.data.length; i++) {
            if (user.uid === this.data[i].uid) {
                this.data[i] = user
            }
        }
    },
    getUsersByPage: function (page, num) {
        let number = (page - 1) * num;
        let offset = number + num
        return this.data.slice(number, offset)
    },
}

module.exports = ResponseEntity
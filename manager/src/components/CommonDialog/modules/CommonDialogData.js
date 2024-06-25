const user = require('./User')
const menu = require('./Menu')

const data = {
    ...user,
    ...menu
}

export function openDialog(key) {
    if (key === null || key.length === 0) {
        return {}
    }
    return data[key]
}

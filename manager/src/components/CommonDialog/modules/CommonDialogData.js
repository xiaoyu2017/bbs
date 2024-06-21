const user = require('./User')

const data = {
    ...user
}

export function openDialog(key) {
    if (key === null || key.length === 0) {
        return {}
    }
    return data[key]
}

const user = require('./user')
const menu = require('./menu')
const article = require('./article')

export default {
    ...user,
    ...menu,
    ...article,
}

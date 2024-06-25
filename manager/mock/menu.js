const menuData = require('./MenuData')

const mockData = {
    'GET /v1/api/menu': (req, res) => {
        let topMenuData = menuData.getTopMenus()
        return res.json({
            error: 0,
            message: 'get user success!',
            data: topMenuData,
            total: topMenuData.length
        })
    },
    'GET /v1/api/menu/:id': (req, res) => {
        let menuChildren = menuData.getMenuChildren(Number(req.params.id))
        return res.json({
            error: 0,
            message: 'get user success!',
            data: menuChildren,
            total: menuChildren.length
        })
    },
    'POST /v1/api/menu': (req, res) => {
        let menu = req.body
        menu.id = menuData.data.length + 1
        menuData.addMenu(menu)
        return res.json({
            error: 0,
            message: 'add success!'
        });
    },
    'PUT /v1/api/menu': (req, res) => {
        menuData.updateMenu(req.body)
        res.send({error: 0, message: 'update success！'});
    },
    'DELETE /v1/api/menu/:id': (req, res) => {
        console.log(JSON.stringify(req.params))
        menuData.deleteMenu(Number(req.params.id))
        res.send({status: 'ok', message: 'delete success!'})
    },
}

module.exports = mockData
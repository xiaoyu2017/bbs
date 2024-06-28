let articleData = [
    {
        id: 1,
        title: '测试文章',
        html: '<p>我的天</p><p>我的天</p><p>我的天</p><p>我的天</p><p>我的天</p><p>我的天</p><p>我的天</p><p>我的天</p><p>我的天</p>',
        value: '我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天我的天',
    }
]
const mockData = {
    'POST /v1/api/article': (req, res) => {
        let article = req.body
        article.id = articleData.length + 1
        articleData.push(article)
        return res.json({
            error: 0,
            message: 'add article success!'
        });
    },
    'GET /v1/api/article': (req, res) => {
        let page = Number(req.query.page)
        let num = Number(req.query.num)
        return res.json({
            error: 0,
            message: 'get user success!',
            data: articleData.slice((page - 1) * num, page + num),
            total: articleData.length
        });
    },
    'DELETE /v1/api/article/:id': (req, res) => {
        let id = Number(req.params.id)
        for (let i = 0; i < articleData.length; i++) {
            if (id === articleData[i].id) {
                articleData.splice(i, 1)
            }
        }
        res.send({status: 'ok', message: 'delete success!'})
    },
}

module.exports = mockData
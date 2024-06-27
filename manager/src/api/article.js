import request from '@/utils/request'

export function getArticlesByPage(page, num) {
    let config = {
        url: '/v1/api/article',
        method: 'get',
        params: {
            page: page,
            num: num
        }
    }
    return request(config)
}

export function deleteArticleByUid(id) {
    let config = {
        url: '/v1/api/article/' + id,
        method: 'delete',
    }
    return request(config)
}

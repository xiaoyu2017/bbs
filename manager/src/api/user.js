import request from '@/utils/request'

export function login(data) {
    return request({
        url: '/user/login',
        method: 'post',
        data
    })
}

export function getInfo(token) {
    return request({
        url: '/user/info',
        method: 'get',
        params: {token}
    })
}

export function logout() {
    return request({
        url: '/user/logout',
        method: 'post'
    })
}

export function apiRoutes(data) {
    return request({
        url: '/user/menu',
        method: 'get',
        params: {
            token: data
        }
    })
}

export function getUsers() {
    return request({
        url: '/v1/api/user',
        method: 'get'
    })
}

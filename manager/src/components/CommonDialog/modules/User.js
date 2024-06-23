module.exports = {
    userAdd: {
        formMetaData: [
            {
                name: 'userName',
                label: '用户名',
                category: 'input',
                type: 'text',
                placeholder: '用户名',
            },
            {
                name: 'nickName',
                label: '用户昵称',
                category: 'input',
                type: 'text',
                placeholder: '用户昵称',
            },
            {
                name: 'password',
                label: '密码',
                category: 'input',
                type: 'text',
                placeholder: '用户密码',
            },
            {
                name: 'email',
                label: '邮箱',
                category: 'input',
                type: 'email',
                placeholder: '用户邮箱',
            }
        ],
        dialogTitle: '新增用户',
        dialogVisible: true,
        requestUrl: '/v1/api/user',
        requestMethod: 'post'
    },
    userEdit: {
        formMetaData: [
            {
                name: 'uid',
                hidden: true
            },
            {
                name: 'userName',
                label: '用户名',
                category: 'input',
                type: 'text',
                placeholder: '用户名',
            },
            {
                name: 'nickName',
                label: '用户昵称',
                category: 'input',
                type: 'text',
                placeholder: '用户昵称',
            },
            {
                name: 'password',
                label: '密码',
                category: 'input',
                type: 'text',
                placeholder: '用户密码',
            },
            {
                name: 'email',
                label: '邮箱',
                category: 'input',
                type: 'email',
                placeholder: '用户邮箱',
            }
        ],
        dialogTitle: '修改用户',
        dialogVisible: true,
        requestUrl: '/v1/api/user',
        requestMethod: 'put'
    },
}


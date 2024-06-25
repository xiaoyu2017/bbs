module.exports = {
    menuAdd: {
        formMetaData: [
            {
                name: 'path',
                label: '路径',
                category: 'input',
                type: 'text',
                placeholder: '路径',
            },
            {
                name: 'name',
                label: '名称',
                category: 'input',
                type: 'text',
                placeholder: '名称',
            },
            {
                name: 'componentPath',
                label: '组件路径',
                category: 'input',
                type: 'text',
                placeholder: '组件路径',
            },
            {
                name: 'redirect',
                label: '重定向路径',
                category: 'input',
                type: 'text',
                placeholder: '重定向路径',
            },
            {
                name: 'hidden',
                label: '隐藏',
                category: 'switch',
                activeText: '是',
                inactiveText: '否',
                type: 'text',
                placeholder: '隐藏',
            },
            {
                name: 'isTree',
                label: '树结构',
                category: 'switch',
                activeText: '是',
                inactiveText: '否',
                type: 'text',
                placeholder: '树结构',
            },
            {
                name: 'hasChildren',
                label: '子菜单',
                category: 'switch',
                activeText: '是',
                inactiveText: '否',
                type: 'text',
                placeholder: '隐藏',
            },
            {
                name: 'parentId',
                label: '父菜单ID',
                category: 'input',
                type: 'text',
                placeholder: '父菜单ID',
            }
        ],
        dialogTitle: '新增菜单',
        dialogVisible: true,
        requestUrl: '/v1/api/menu',
        requestMethod: 'post'
    },
    menuEdit: {
        formMetaData: [
            {
                name: 'id',
                hidden: true
            },
            {
                name: 'path',
                label: '路径',
                category: 'input',
                type: 'text',
                placeholder: '路径',
            },
            {
                name: 'name',
                label: '名称',
                category: 'input',
                type: 'text',
                placeholder: '名称',
            },
            {
                name: 'componentPath',
                label: '组件路径',
                category: 'input',
                type: 'text',
                placeholder: '组件路径',
            },
            {
                name: 'redirect',
                label: '重定向路径',
                category: 'input',
                type: 'text',
                placeholder: '重定向路径',
            },
            {
                name: 'hidden',
                label: '隐藏',
                category: 'switch',
                activeText: '是',
                inactiveText: '否',
                type: 'text',
                placeholder: '隐藏',
            },
            {
                name: 'isTree',
                label: '树结构',
                category: 'switch',
                activeText: '是',
                inactiveText: '否',
                type: 'text',
                placeholder: '树结构',
            },
            {
                name: 'hasChildren',
                label: '子菜单',
                category: 'switch',
                activeText: '是',
                inactiveText: '否',
                type: 'text',
                placeholder: '隐藏',
            },
            {
                name: 'parentId',
                label: '父菜单ID',
                category: 'input',
                type: 'text',
                placeholder: '父菜单ID',
            }
        ],
        dialogTitle: '修改菜单',
        dialogVisible: true,
        requestUrl: '/v1/api/menu',
        requestMethod: 'put'
    },
}


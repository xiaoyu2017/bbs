let MenuResponseEntity = {
    data: [
        {
            id: 1,
            path: '/',
            name: 'home',
            componentPath: '@/layout',
            redirect: '/dashboard',
            meta: {
                title: 'Dashboard',
                icon: 'el-icon-s-data'
            },
            isTree: true
        },
        {
            id: 11,
            path: 'dashboard',
            componentPath: '@/views/dashboard/index',
            name: 'Dashboard',
            meta: {title: 'dashboard'},
            parentId: 1
        },
        {
            id: 2,
            path: '/user',
            name: 'User',
            componentPath: '@/layout',
            meta: {
                title: 'User',
                icon: 'el-icon-user-solid'
            },
            hasChildren: true,
            isTree: true
        },
        {
            id: 21,
            path: 'controller',
            componentPath: '@/views/user/controller',
            name: 'controller',
            meta: {title: 'controller', icon: 'el-icon-minus'},
            parentId: 2
        },
        {
            id: 22,
            path: 'manager',
            componentPath: '@/views/user/manager',
            name: 'manager',
            meta: {title: 'manager', icon: 'el-icon-minus'},
            parentId: 2
        },
        {
            id: 3,
            path: '/menu',
            name: 'Menu',
            componentPath: '@/layout',
            redirect: '/menu/index',
            meta: {
                title: 'Menu',
                icon: 'el-icon-menu'
            },
            isTree: true
        },
        {
            id: 31,
            path: 'index',
            componentPath: '@/views/menu/index',
            name: 'index',
            parentId: 3
        },
        {
            id: 4,
            path: '/role',
            name: 'Role',
            componentPath: '@layout',
            redirect: '/role/index',
            meta: {
                title: 'Role',
                icon: 'el-icon-files'
            },
            isTree: true
        },
        {
            id: 41,
            path: 'index',
            componentPath: '@/views/role/index',
            name: 'index',
            parentId: 4
        },
        {
            id: 5,
            path: '/group',
            name: 'Group',
            component: '@/layout',
            redirect: '/group/index',
            meta: {
                title: 'Group',
                icon: 'el-icon-s-custom'
            },
            isTree: true
        },
        {
            id: 51,
            path: 'index',
            componentPath: '@/views/group/index',
            name: 'index',
            parentId: 5
        },
        {
            id: 6,
            path: '/attachment',
            name: 'Attachment',
            component: '@/layout',
            redirect: '/attachment/index',
            meta: {
                title: 'Attachment',
                icon: 'el-icon-picture'
            },
            isTree: true
        },
        {
            id: 61,
            path: 'index',
            componentPath: '@/views/attachment/index',
            name: 'index',
            parentId: 6
        },
        {
            id: 7,
            path: '/setting',
            name: 'Setting',
            componentPath: '@/layout',
            redirect: '/setting/index',
            meta: {
                title: 'Setting',
                icon: 'el-icon-setting'
            },
            isTree: true
        },
        {
            id: 71,
            path: 'index',
            componentPath: '@/views/setting/index',
            name: 'index',
            parentId: 7
        },
        {
            id: 8,
            path: '/login',
            componentPath: '@/views/login/index',
            hidden: true
        }],
    addMenu: function (menu) {
        this.data.push(menu)
    },
    deleteMenu: function (id) {
        for (let i = 0; i < this.data.length; i++) {
            if (id === this.data[i].id) {
                this.data.splice(i, 1)
            }
        }
    },
    updateMenu: function (menu) {
        for (let i = 0; i < this.data.length; i++) {
            if (menu.id === this.data[i].id) {
                this.data[i] = menu
            }
        }
    },
    getTopMenus: function () {
        let menuArray = []
        for (let i = 0; i < this.data.length; i++) {
            if (this.data[i].parentId === undefined || this.data[i].parentId === null) {
                menuArray.push(this.data[i]);
            }
        }
        return menuArray
    },
    getMenuChildren: function (id) {
        let menuArray = []
        for (let i = 0; i < this.data.length; i++) {
            if (this.data[i].parentId !== undefined && this.data[i].parentId !== null) {
                if (this.data[i].parentId === id) {
                    menuArray.push(this.data[i]);
                }
            }
        }
        return menuArray
    },
}

module.exports = MenuResponseEntity
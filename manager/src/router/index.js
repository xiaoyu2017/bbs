import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layout'

Vue.use(VueRouter)

export const routes = [
    {
        path: '/',
        name: 'home',
        component: Layout,
        redirect: '/dashboard',
        meta: {
            title: 'Dashboard',
            icon: 'el-icon-s-data'
        },
        children: [
            {
                path: 'dashboard',
                component: () => import('@/views/dashboard/index'),
                name: 'Dashboard',
                meta: {title: 'dashboard'}
            }
        ]
    },
    {
        path: '/user',
        name: 'User',
        component: Layout,
        meta: {
            title: 'User',
            icon: 'el-icon-user-solid'
        },
        hasChildren: true,
        children: [
            {
                path: 'controller',
                component: () => import('@/views/user/controller'),
                name: 'controller',
                meta: {title: 'controller', icon: 'el-icon-minus'}
            },
            {
                path: 'manager',
                component: () => import('@/views/user/manager'),
                name: 'manager',
                meta: {title: 'manager', icon: 'el-icon-minus'}
            }
        ]
    },
    {
        path: '/menu',
        name: 'Menu',
        component: Layout,
        redirect: '/menu/index',
        meta: {
            title: 'Menu',
            icon: 'el-icon-menu'
        },
        children: [
            {
                path: 'index',
                component: () => import('@/views/menu/index'),
                name: 'index',
            }
        ]
    },
    {
        path: '/role',
        name: 'Role',
        component: Layout,
        redirect: '/role/index',
        meta: {
            title: 'Role',
            icon: 'el-icon-files'
        },
        children: [
            {
                path: 'index',
                component: () => import('@/views/role/index'),
                name: 'index',
            }
        ]
    },
    {
        path: '/group',
        name: 'Group',
        component: Layout,
        redirect: '/group/index',
        meta: {
            title: 'Group',
            icon: 'el-icon-s-custom'
        },
        children: [
            {
                path: 'index',
                component: () => import('@/views/group/index'),
                name: 'index',
            }
        ]
    },
    {
        path: '/attachment',
        name: 'Attachment',
        component: Layout,
        redirect: '/attachment/index',
        meta: {
            title: 'Attachment',
            icon: 'el-icon-picture'
        },
        children: [
            {
                path: 'index',
                component: () => import('@/views/attachment/index'),
                name: 'index',
            }
        ]
    },
    {
        path: '/setting',
        name: 'Setting',
        component: Layout,
        redirect: '/setting/index',
        meta: {
            title: 'Setting',
            icon: 'el-icon-setting'
        },
        children: [
            {
                path: 'index',
                component: () => import('@/views/setting/index'),
                name: 'index',
            }
        ]
    },
    {
        path: '/article',
        name: 'Article',
        component: Layout,
        hasChildren: true,
        meta: {
            title: 'Article',
            icon: 'el-icon-notebook-2'
        },
        children: [
            {
                path: 'ArticleManager',
                component: () => import('@/views/article/ArticleManager'),
                name: 'ArticleManager',
                meta: {title: 'ArticleManager', icon: 'el-icon-minus'}
            },
            {
                path: 'ArticleEditor',
                component: () => import('@/views/article/ArticleEditor'),
                name: 'ArticleEditor',
                meta: {title: 'ArticleEditor', icon: 'el-icon-minus'}
            },
        ]
    },
    {
        path: '/login',
        component: () => import('@/views/login/index'),
        hidden: true
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router

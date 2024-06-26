import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/layout'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'home',
        component: Layout,
        redirect: '/home',
        children: [
            {
                path: 'home',
                component: () => import('@/views/home/index'),
                name: 'Home',
            }
        ]
    },
    {
        path: '/article',
        name: 'Article',
        component: Layout,
        redirect: '/article/index',
        children: [
            {
                path: 'index',
                component: () => import('@/views/article/index'),
                name: 'Index',
            },
            {
                path: 'editor',
                component: () => import('@/views/article/editor'),
                name: 'Editor',
            }
        ]
    },
    {
        path: '/login',
        name: 'Login',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '@/views/login')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router

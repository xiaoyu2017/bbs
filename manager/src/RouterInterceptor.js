// 路由访问过滤器
import router from './router'
import store from './store'
import {Message} from 'element-ui'
import NProgress from 'nprogress'
import 'nprogress/nprogress.css'

// 配置进度条
NProgress.configure({showSpinner: false})
// 白名单
const whiteList = ['/login']

// 路由（拦截器）开始前
router.beforeEach(async (to, from, next) => {
    //进度条开始
    NProgress.start()
    // 通过Api获得动态路由
    // const data = await store.dispatch('menu/getMenus')

    // console.log(JSON.stringify(data));

    next()

    /*// 设置页面title
    document.title = getPageTitle(to.meta.title)
    // 获得用户登录token，如果有用户已登录
    const hasToken = store.getters.token

    console.log(hasToken)

    if (hasToken) { // 已经登录
        if (to.path === '/login') {
            // 已登录又是白名单，直接跳转到主页
            next({path: '/'})
            // 进度条结束
            NProgress.done()
        } else {
            // 确定用户是否有角色
            const hasRoles = store.getters.roles && store.getters.roles.length > 0;

            if (hasRoles) {
                // 有角色直接放行
                next()
            } else {

                try {
                    // 异步获得用户信息，用户的角色必须是数组  ['admin'] 或者 ['developer','editor']
                    const {roles} = await store.dispatch('user/getInfo')
                    // 根据角色生成路由信息 TODO 应该使用异步请求获得，可缓存
                    const accessRoutes = await store.dispatch('permission/generateRoutes', roles)
                    // 通过Api获得动态路由
                    const data = await store.dispatch('permission/getApiRoutes')

                    for (let i = 0; i < data.length; i++) {
                        accessRoutes.push(data[i])
                    }
                    // 动态添加路由信息
                    router.addRoutes(accessRoutes)
                    // 解决动态路由添加产生白屏问题
                    next({...to, replace: true})
                } catch (error) {
                    // 获得用户信息失败，则需要重新登录

                    // 重新设置用户token
                    await store.dispatch('user/resetToken');
                    // 显示错误信息
                    Message.error(error || 'Has Error')
                    // 设置需要跳转的路径
                    next(`/login?redirect=${to.path}`)
                    // 结束进度条
                    NProgress.done()
                }
            }
        }
    } else {
        // 没有登录，判断是否在白名单中
        if (whiteList.indexOf(to.path) !== -1) {
            next()
        } else {
            // 无权访问页面将被重定向到登录页面
            next(`/login?redirect=${to.path}`)
            NProgress.done()
        }
    }*/
});

router.afterEach(() => {
    // 关闭进度条
    NProgress.done()
})

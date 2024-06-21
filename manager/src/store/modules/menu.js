import {getMenu} from "@/api/menu";

const state = {
    menus: []
}

const mutations = {
    SET_MENU: (state, menus) => {
        state.menus = menus
    },
}

const actions = {
    getMenus({commit}) {
        return new Promise((resolve, reject) => {
            getMenu().then(response => {
                const {data} = response
                // 设置token状态
                commit('SET_MENU', data.data)
                resolve()
            }).catch(error => {
                reject(error)
            });
        })
    }
}

export default {
    namespaced: true,
    state,
    mutations,
    actions
}

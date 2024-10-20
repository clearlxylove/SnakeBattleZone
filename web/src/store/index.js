import { createStore } from 'vuex'
import ModuleUser from './user'
import createPersistedState from "vuex-persistedstate"
import ModulePK from './pk'
import ModuleRecord from './record'

export default createStore({
  state: {
  },
  getters: {
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    user : ModuleUser,
    pk:ModulePK,
    record:ModuleRecord,
  },

  // Vuex持久化插件(vuex-persistedstate)解决刷新数据消失的问题
  // 下面的写法，会默认持久化所有state

  plugins: [createPersistedState({
    // 存储在 localStorage 的数据可以长期保留
    // 当页面被关闭时，存储在 sessionStorage 的数据会被清除
    storage: window.sessionStorage,
    reducer(val) {
      return {
        user: val.user,
      }
    }
  })]
})

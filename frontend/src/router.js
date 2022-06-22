
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LoginManager from "./components/listers/LoginCards"
import LoginDetail from "./components/listers/LoginDetail"

import CustomerManager from "./components/listers/CustomerCards"
import CustomerDetail from "./components/listers/CustomerDetail"

import SmartbankingManager from "./components/listers/SmartbankingCards"
import SmartbankingDetail from "./components/listers/SmartbankingDetail"

import AccountManager from "./components/listers/AccountCards"
import AccountDetail from "./components/listers/AccountDetail"


import Customerinfo from "./components/Customerinfo"
export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/logins',
                name: 'LoginManager',
                component: LoginManager
            },
            {
                path: '/logins/:id',
                name: 'LoginDetail',
                component: LoginDetail
            },

            {
                path: '/customers',
                name: 'CustomerManager',
                component: CustomerManager
            },
            {
                path: '/customers/:id',
                name: 'CustomerDetail',
                component: CustomerDetail
            },

            {
                path: '/smartbankings',
                name: 'SmartbankingManager',
                component: SmartbankingManager
            },
            {
                path: '/smartbankings/:id',
                name: 'SmartbankingDetail',
                component: SmartbankingDetail
            },

            {
                path: '/accounts',
                name: 'AccountManager',
                component: AccountManager
            },
            {
                path: '/accounts/:id',
                name: 'AccountDetail',
                component: AccountDetail
            },


            {
                path: '/customerinfos',
                name: 'Customerinfo',
                component: Customerinfo
            },


    ]
})


import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import LoginManager from "./components/LoginManager"

import Logincqrs from "./components/Logincqrs"
import CustomerManager from "./components/CustomerManager"

import SmartbankingManager from "./components/SmartbankingManager"

import AccountManager from "./components/AccountManager"

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
                path: '/logincqrs',
                name: 'Logincqrs',
                component: Logincqrs
            },
            {
                path: '/customers',
                name: 'CustomerManager',
                component: CustomerManager
            },

            {
                path: '/smartbankings',
                name: 'SmartbankingManager',
                component: SmartbankingManager
            },

            {
                path: '/accounts',
                name: 'AccountManager',
                component: AccountManager
            },



    ]
})

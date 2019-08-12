import Vue from 'vue'

import Home from './components/pages/home'
import Client from './components/pages/clients/client'
import IndividualClient from './components/pages/clients/individual'
import CorporateClient from './components/pages/clients/corporate'
import Loan from './components/pages/loans/loan'
import CorporateLoan from './components/pages/loans/corporate'
import IndividualLoan from './components/pages/loans/individual'
import BootstrapVue from 'bootstrap-vue'
import User from './components/pages/settings/users'
import Branches from './components/pages/settings/branches'
import Role from './components/pages/settings/role'
import Profile from './components/pages/settings/profile'


Vue.use(BootstrapVue);

Vue.component('home',Home);
Vue.component('client',Client);
Vue.component('corporateclient',CorporateClient);
Vue.component('individualclient',IndividualClient);
Vue.component('loan',Loan);
Vue.component('individualloan',IndividualLoan);
Vue.component('corporateloan',CorporateLoan);
Vue.component('user',User);
Vue.component('branch',Branches);
Vue.component('role',Role);
Vue.component("profile",Profile);
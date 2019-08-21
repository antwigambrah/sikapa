import Vue from 'vue'

import Home from './components/pages/home'
import Client from './components/pages/clients/client'
import CreateIndividualClient from './components/pages/clients/create-individual'
import IndividualClient from './components/pages/clients/individual'
import BusinessClient from './components/pages/clients/business'
import Loan from './components/pages/loans/loan'
import LoanSettings from './components/pages/loans/loan-settings.vue'
import CorporateLoan from './components/pages/loans/corporate'
import IndividualLoan from './components/pages/loans/individual'
import BootstrapVue from 'bootstrap-vue'
import User from './components/pages/settings/users'
import Branches from './components/pages/settings/branches'
import Role from './components/pages/settings/role'
import Profile from './components/pages/settings/profile'
import datePicker from 'vue-bootstrap-datetimepicker';
import 'pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css';

Vue.use(datePicker);


Vue.use(BootstrapVue);

Vue.component('home',Home);
Vue.component('client',Client);
Vue.component('businessclient',BusinessClient);
Vue.component('createindividualclient',CreateIndividualClient);
Vue.component('loan',Loan);
Vue.component('loansettings',LoanSettings)
Vue.component('individualloan',IndividualLoan);
Vue.component('corporateloan',CorporateLoan);
Vue.component('user',User);
Vue.component('branch',Branches);
Vue.component('role',Role);
Vue.component("profile",Profile);
Vue.component('individualclient',IndividualClient)
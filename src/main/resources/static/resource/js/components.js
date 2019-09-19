import Vue from 'vue'

import Home from './components/pages/home'
import Loan from './components/pages/loans/loan'
import LoanSettings from './components/pages/loans/loan-settings.vue'
import LoanProducts from './components/pages/loans/loan-products'
import IndividualLoan from './components/pages/loans/individual'
import BootstrapVue from 'bootstrap-vue'
import User from './components/pages/settings/users'
import Branches from './components/pages/settings/branches'
import Profile from './components/pages/settings/profile'
import datePicker from 'vue-bootstrap-datetimepicker';
import 'pc-bootstrap4-datetimepicker/build/css/bootstrap-datetimepicker.css';

Vue.use(datePicker);

Vue.use(BootstrapVue);

Vue.component('home',Home);
Vue.component('loan',Loan);
Vue.component('loansettings',LoanSettings);
Vue.component('loan-products',LoanProducts);
Vue.component('individualloan',IndividualLoan);
Vue.component('user',User);
Vue.component('branch',Branches);
Vue.component("profile",Profile);
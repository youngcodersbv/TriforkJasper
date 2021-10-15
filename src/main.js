import { createApp } from "vue";


import App from "./App.vue";
import Vuex from "vuex";

import storeData from "./store/index";



const store = new Vuex.Store(storeData);

createApp(App).use(store).mount("#app");

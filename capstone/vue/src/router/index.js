import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import MapWithPins from '../components/MapWithPins.vue'
import store from '../store/index'
import Tenant from '../views/Tenant.vue'
import Landlord from '../views/Landlord.vue'
import AddProperty from '../views/AddProperty.vue'
import User from '../views/User.vue'
import Employee from '../views/Employee.vue'
import CloudinaryComp from "../components/CloudinaryComp.vue"
import AddPropertyFormPage from "../views/AddPropertyFormPage.vue"
import PropertyDetails from "../views/PropertyDetails.vue"
import AboutUs from "../views/AboutUs.vue"
import ContactUs from "../views/ContactUs.vue"



Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/AddProperty",
      name: "AddProperty",
      component: AddProperty,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/tenant",
      name: "tenant",
      component: Tenant,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/addpropformpage",
      name: "addpropformpage",
      component: AddPropertyFormPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/landlord",
      name: "landlord",
      component: Landlord,
      meta: {
        requiresAuth: true,
      },
    },

      {
        path: "/user",
        name: "user",
        component: User,
        meta: {
          requiresAuth: true, //Change this after complete
        }
      },
      {
        path: "/employee",
        name: "employee",
        component: Employee,
        meta: {
          requiresAuth: true, //Change this after complete
        }
      },
      {
      path: "/map",
      name: "map",
      component: MapWithPins,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/aboutus",
      name: "aboutus",
      component: AboutUs,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/contactus",
      name: "contactus",
      component: ContactUs,
      meta: {
        requiresAuth: false
      }
    },
      {
        path: "/cloudinary",
        name: "cloudinary",
        component: CloudinaryComp,
        meta: {
          requiresAuth: false
        }
      },

    
      {
        path: "/PropertyDetails/:id",
        name: "PropertyDetails",
        component: PropertyDetails,
        meta: {
          requiresAuth: false
        }
      }
    
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;

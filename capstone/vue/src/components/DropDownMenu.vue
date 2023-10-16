<template>

  <section class="dropDownMenuWrapper">

   <button class="dropDownMenuButton" ref="menu" @click="openClose"></button>

    <div class="iconWrapper">
      <div class="bar1" :class="{ 'bar1--open' : isOpen }" />
      <div class="bar2" :class="{ 'bar2--open' : isOpen }" />
      <div class="bar3" :class="{ 'bar3--open' : isOpen }" />
    </div>

    <section class="dropdownMenu" v-if="isOpen" >
      <div class="menuArrow" />
      <slot/>
      <dropdown-menu menu-title="Vue Dropdown Menu" dark-mode="auto">

  <section class="option">
    <router-link to="/user">Account</router-link>
    <span class="desc"> Check balance or Pay rent.</span>
  </section>

  <section class="option">
   <router-link to="/aboutus">About us</router-link>
   <span class="desc">About RentRoost.</span>
  </section>

  <section class="option">
    <router-link to="/AddProperty">Add a Property</router-link>
    <span class="desc">Upload your Roost.</span>
  </section>
  <section class="option">
    <router-link to="/contactus">Contact Us</router-link>
    <span class="desc">Get to know the team!</span>
  </section>

</dropdown-menu>
    </section>

  </section>

</template>

<script>

export default {
  props: ["darkMode", "menuTitle"],
  data() {
    return {
      isOpen: false,
      isDarkMode: false,
    };
  },

  methods: {
    openClose() {
      var _this = this;

      const closeListerner = (e) => {
        // Check if user clicks outside of the menu
        // true — close the menu and remove EventListener
        if (_this.catchOutsideClick(e, _this.$refs.menu))
          window.removeEventListener("click", closeListerner),
            (_this.isOpen = false);
      };

      // Add event listener to watch clicks outside the menu
      window.addEventListener("click", closeListerner);

      // Close if open and vice versa
      this.isOpen = !this.isOpen;
    },

    catchOutsideClick(event, dropdown) {
      // When user clicks menu — do nothing
      if (dropdown == event.target) return false;

      // When user clicks outside of the menu — close the menu
      if (this.isOpen && dropdown != event.target) return true;
    },
  },
}
</script>

<style scoped>
.dropDownMenuWrapper {
  position: relative;
  width: 70px;
  height: 30px;
  border-radius: 8px;
  background: rgba(216, 216, 216, 0);
  border: 0px solid rgba(238, 238, 238, 0);
  box-shadow: rgba(255, 255, 255, 0) 0px 1px 4px;
  -webkit-tap-highlight-color: rgba(255, 255, 255, 0);
}
  * {
    box-sizing: border-box;
    text-align: left;
  }

  .dropDownMenuButton {
    color:rgba(255, 255, 255, 0);
    display: flex;
    align-content: space-between;
    border: none;
    font-size: inherit;
    background: none;
    border: none;
    outline: none;
    border-radius: 4px;
    position: absolute;
    top: 0;
    left: 0;
    display: flex;
    align-items: center;
    padding: 0 70px 0 20px;
    margin: 0;
    line-height: 1;
    width: 100%;
    height: 100%;
    z-index: 2;
    cursor: pointer;
    box-shadow: none;
  }

  .dropDownMenuButton--dark {
    color: #333;
  }

  .iconWrapper {
    width: 30px;
    height: 30px;
    position: absolute;
    right: 5px;
    top: 55%;
    transform: translate(0,-50%);
    z-index: 1;
  }
    .bar1 {
      width: 100%;
      max-width: 28px;
      height: 3px;
      background: rgba(116, 116, 116, 0.74);
      position: absolute;
      margin-top: 5px;
      top: 50%;
      left: 50%;
      border-radius: 9999px;
      transform: translate(-50%, calc(-50% - 8px) );
      transition: all 0.2s ease;
    }

    .bar1--dark {
      background: #eee;
    }

    .bar1--open {
      transform: translate(-50%, -50%) rotate(45deg);
      margin-top: 10;
      background: rgb(255, 0, 0);
      padding-right: 30px;
    }

    .bar2 {
      width: 100%;
      max-width: 28px;
      height: 3px;
      background:  rgba(116, 116, 116, 0.74);
      position: absolute;
      margin-top: 5px;
      top: 50%;
      left: 50%;
      border-radius: 9999px;
      opacity: 1;
      transform: translate(-50%, -50%);
      transition: all 0.2s ease;
    }

    .bar2--dark {
      background: #eee;
    }

    .bar2--open {
      opacity: 0;
    }

    .bar3 {
      width: 100%;
      max-width: 28px;
      height: 3px;
      background:  rgba(116, 116, 116, 0.74);
      position: absolute;
      margin-top: 5px;
      top: 50%;
      left: 50%;
      border-radius: 9999px;
      transform: translate(-50%, calc(-50% + 8px) );
      transition: all 0.2s ease;
    }

    .bar3--dark {
      background: #eee;
    }

    .bar3--open {
      top: 50%;
      padding-right: 30px;
      transform: translate(-50%, -50% ) rotate(-45deg);
      background: rgb(255, 0, 0);
    }

  

  .iconWrapper--noTitle {
    left: 0;
    top: 0;
    bottom: 0;
    right: 0;
    width: auto;
    height: auto;
    transform: none;
  }

  .dropdownMenu {
    position: absolute;
    top: 100%;
    width: 100%;
    min-width: 300px;
    min-height: 10px;
    border-radius: 8px;
    border: 1px solid #eee;
    box-shadow: rgba(0, 0, 0, 0.16) 0px 1px 4px;
    background: rgb(255, 255, 255);
    padding: 10px 30px;
    animation: menu 0.3s ease forwards;
  }
    .menuArrow {
      width: 20px;
      height: 20px;
      position: absolute;
      top: -10px;
      left: 20px;
      border-left: 1px solid #eee;
      border-top: 1px solid #eee;
      background: white;
      transform: rotate(45deg);
      border-radius: 4px 0 0 0;
    }

    .menuArrow--dark {
      background: #333;
      border: none;
    }

    .option {
      width: 100%;
      border-bottom: 1px solid rgb(238, 238, 238);
      padding: 20px 0;
      cursor: pointer;
      position: relative;
      z-index: 2;
      color: rgb(255, 15, 15)
    }
    

      * {
        color: inherit;
        text-decoration: none;
        background: none;
        border: 0;
        padding: 0;
        outline: none;
        cursor: pointer;
      }

    

    .desc {
      opacity: 0.5;
      display: block;
      width: 100%;
      font-size: 14px;
      margin: 3px 0 0 0;
      cursor: default;
      color: rgba(0, 0, 0, 0.651);
      font-weight: bold;
    }

  

  .dropdownMenu--dark {
    background: #333;
    border: none;
  }
    .option {
      border-bottom: 1px solid #888;
    }

    * {
      color:rgba(255, 0, 0, 0.596);
    }

  

  @keyframes menu {
    from { transform: translate3d( 0, 30px ,0 ) }
    to { transform: translate3d( 0, 25px ,0 ) }
  }



.dropDownMenuWrapper--noTitle {
  padding: 0;
  width: 60px;
  height: 60px;
}

.dropDownMenuWrapper--dark {
  background: #333;
  border: none;
}
</style>

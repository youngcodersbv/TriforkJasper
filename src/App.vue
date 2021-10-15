<template>
  <add-note />
  <Notes />
</template>

<script>
import AddNote from './components/AddNote.vue';
import Notes from "./components/Notes.vue";

export default {
  name: "App",
  components: {
    Notes,
    AddNote,
  },
    created() {
        this.$store.dispatch("notes/getNotes");   
    },
};
  
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

<template lang="">
    <div>
         <table>
        <thead>
            <tr>
              
                <td>Title</td>
                <td>Body</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(note) in notes" :key="note.id">
            
                <td>{{note.title}}</td>
                <td>{{note.body}}</td>
            </tr>
        </tbody>
    </table>
    </div>
</template>
<script>
export default {
      computed: {
        notes() {
                console.log(this.$store.state.notes.notes);
                return this.$store.state.notes.notes;
        },
    }
}

</script>
<style lang="">
    
</style>
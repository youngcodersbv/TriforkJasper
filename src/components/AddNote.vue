<template>
    <div class="container">
     
            <label >Title:</label>
            <div>
                <input
                    type="text"
                    @input="updateTitle"
                    :value="title"
                   
                />
            </div>
             <label >Body:</label>
            <div >
                <input
                    type="text"
                    @input="updateBody"
                    :value="body"
                />
            </div>
 <button
                       
                        @click="postNote()"
                    >
                        Sign In
                    </button>
        </div>
              
   
</template>

<script>
import { mapActions} from "vuex";
export default {
    data() {
        return {};
    },
    methods: {
        ...mapActions("notes", ["postNote"]),
        updateTitle(event) {
            this.$store.commit("notes/setTitle", event.target.value);
        },
        updateBody(event) {
            this.$store.commit("notes/setBody", event.target.value);
        },
    },
    
};
</script>

<style></style>

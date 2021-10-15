export default {
    namespaced: true,
    state: {
        notes: [],
        title: '',
        body: '',
    },

    getters: {
        getNotes(state) {
            return state.notes;
        },
    },

    actions: {
        getNotes({commit}) {
            fetch('http://localhost:8080/json/notes')
                .then(res => res.json())           
                .then(json => { commit("setNotes", json); });
        },
        postNote({state}){
            const params = {
                title: state.title,
                body: state.body,
            };
            const options = {
                method: 'POST',
                body: JSON.stringify( params )  
            };
            // POST request using fetch()
            fetch( 'https://localhost:8080/notes', options )
        }
    },
    mutations: {
        setNotes(state, payload) {
            state.notes = payload;
        },
        setTitle(state, payload) {
            state.title = payload;
        },
        setBody(state, payload) {
            state.body = payload;
        },

        
    }
}

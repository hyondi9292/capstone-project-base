<template>
    <div style="margin: 0 -15px 0 -15px;">
        <v-card-title  v-if="editMode">
            {{label}}
        </v-card-title>
        <v-card-title  v-if="!editMode">
            Your Profile
        </v-card-title>

        <v-card-text v-if="value">
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Id" v-model="value.id"/>
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Password" v-model="value.password"/>
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Name" v-model="value.name"/>
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Email" v-model="value.email"/>
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Address" v-model="value.address"/>
            </div>
            <div v-if="editMode" style="margin-top:-20px;">
                <v-text-field label="Phone" v-model="value.phone"/>
            </div>
            <div v-if="!editMode">
                <v-card
                    v-if="!editMode"
                    class="mx-auto"
                    max-width="400"
                    style="margin-bottom:10px;"
                >
                    <v-row
                        align="end"
                        class="fill-height"
                    >
                        <v-col
                        align-self="start"
                        class="pa-0"
                        cols="12"
                        >
                        </v-col>
                        <v-col class="py-0">
                        <v-avatar color="grey" style="margin: 15px 0 -5px 15px;">
                            <v-icon x-large dark>
                                mdi-account-circle
                            </v-icon>
                        </v-avatar>
                        <v-list-item
                            color="rgba(0, 0, 0, .4)"
                        >
                            <v-list-item-content>
                                <v-list-item-title class="text-h6">
                                    {{value.name }}
                                </v-list-item-title>
                                <v-list-item-subtitle style="font-weight:500;">
                                    Id :  {{value.userId }}<br>
                                    Password :  {{value.password }}<br>
                                    Email :  {{value.email }}<br>
                                    Address :  {{value.address }}<br>
                                    Phone :  {{value.phone }}
                                </v-list-item-subtitle>
                            </v-list-item-content>
                        </v-list-item>
                        </v-col>
                    </v-row>
                </v-card>
            </div>
        </v-card-text>
    </div>
</template>

<script>
    export default {
        name:"User",
        props: {
            editMode: Boolean,
            value : Object,
            label : String, 
        },
        created(){
            if(!this.value) {
                this.value = {
                    'id': '',
                    'password': '',
                    'name': '',
                    'email': '',
                    'address': '',
                    'phone': '',
                };
            }
        },
        watch: {
            value(newVal) {
                this.$emit('input', newVal);
            },
        },
    }
</script>

<style scoped>
</style>
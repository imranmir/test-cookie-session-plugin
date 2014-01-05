package com.im

//import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.annotation.Secured

class UserController {

    @Secured(["ROLE_ADMIN"])
    def index() {
        redirect(action: 'index2')
    }

    @Secured(["ROLE_ADMIN"])
    def index2(){
        render (view: 'index')
    }

    def afterLogout(){
        render "You are logout"
    }
}

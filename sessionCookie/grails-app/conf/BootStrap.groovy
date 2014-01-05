import com.im.Role
import com.im.User
import com.im.UserRole

class BootStrap {

    def init = { servletContext ->
        Role r = new Role(authority: 'ROLE_ADMIN').save(flush:true)
        User u = new User(username: 'imran', password: 'pwd',enabled: true)
        u.save(flush: true)
        println "Role is "+r
        println "User  is "+u
//        def ur = UserRole.create u, r, true
        def ur = new UserRole(user: User.findByUsername("imran"), role: Role.findByAuthority("ROLE_ADMIN"))
        println "User role is "+ur.validate()
        println "errors "+ur.errors
        ur.save(flush: true, failOnError: true)
        if(!ur.validate()){
            println " errrorsss "+ur.errors
        }else{
            println ">>>>>>>>>>>>>>>.. about to save "
            ur.save(flush: true)
        }

        println "Role created "+r
        println "User created "+u
        println "User Role created "+ur

    }
    def destroy = {
    }
}

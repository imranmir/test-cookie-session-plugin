package com.im

class ApplicationFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                println "Controller and action "+params

            }
            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}

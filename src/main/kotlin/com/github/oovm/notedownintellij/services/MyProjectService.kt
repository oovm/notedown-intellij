package com.github.oovm.notedownintellij.services

import com.intellij.openapi.project.Project
import com.github.oovm.notedownintellij.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

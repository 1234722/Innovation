package com.example.innovation

interface NavDestination {
    val route: String
}

object Main : NavDestination {
    override val route: String = "main"
}

object Todo : NavDestination {
    override val route: String = "todo"
}

object Profile : NavDestination {
    override val route: String = "profile"
}

object Guide : NavDestination {
    override val route: String = "guide"
}
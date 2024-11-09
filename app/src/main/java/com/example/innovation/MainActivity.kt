package com.example.innovation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.innovation.ui.components.TabComponent
import com.example.innovation.ui.screen.GuideScreen
import com.example.innovation.ui.screen.MainScreen
import com.example.innovation.ui.screen.ProfileScreen
import com.example.innovation.ui.screen.TodoScreen
import com.example.innovation.ui.state.GuideUIState
import com.example.innovation.ui.state.MainUIState
import com.example.innovation.ui.state.ProfileUIState
import com.example.innovation.ui.state.TodoUIState
import com.example.innovation.ui.theme.InnovationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navDestinations = listOf(
            Main,
            Todo,
            Guide,
            Profile
        )

        val tabLabels = listOf(
            "主页",
            "待办",
            "指导",
            "我的"
        )

        val Icons = listOf(
            R.drawable.home,
            R.drawable.list_box_outline,
            R.drawable.book_open_variant_outline,
            R.drawable.account_outline
        )

        setContent {
            InnovationTheme {
                val navController = rememberNavController()

                // 主界面的Tab组件
                @Composable
                fun mainTabComponent(modifier: Modifier, target: NavDestination) {
                    TabComponent(modifier = modifier,
                        destinations = navDestinations,
                        labels = tabLabels,
                        select = target,
                        labelIcons = Icons,
                        onItemClick = {
                            navController.navigateSingleTopTo(
                                it.route, target.route
                            )
                        })
                }




                Surface {
                    NavHost(
                        navController = navController,
                        startDestination = Main.route
                    ) {
                        // 主页
                        composable(route = Main.route,
                            exitTransition = { fadeOut(animationSpec = tween(0)) },
                            enterTransition = { fadeIn(animationSpec = tween(0)) }) {backStackEntry ->
                            val mainBackStackEntry =
                                remember(backStackEntry) { navController.getBackStackEntry(Main.route) }
                            val mainUIState: MainUIState = viewModel(mainBackStackEntry)
                            MainScreen(modifier = Modifier.fillMaxSize(),viewModel = mainUIState) { mainTabComponent(it, Main) }
                        }

                        // 待办
                        composable(route =Todo.route,
                            exitTransition = { fadeOut(animationSpec = tween(0)) },
                            enterTransition = { fadeIn(animationSpec = tween(0)) }) {backStackEntry ->
                            val mainBackStackEntry =
                                remember(backStackEntry) { navController.getBackStackEntry(Todo.route) }
                            val todoUIState: TodoUIState = viewModel(mainBackStackEntry)
                            TodoScreen(modifier = Modifier.fillMaxSize(), viewModel = todoUIState){ mainTabComponent(it, Todo) }
                        }

                        // 指南
                        composable(route = Guide.route,
                            exitTransition = { fadeOut(animationSpec = tween(0)) },
                            enterTransition = { fadeIn(animationSpec = tween(0)) }) { backStackEntry ->
                            val guideBackStackEntry =
                                remember(backStackEntry) { navController.getBackStackEntry(Guide.route) }
                            val guideUIState: GuideUIState = viewModel(guideBackStackEntry)
                            GuideScreen(modifier = Modifier.fillMaxSize(), viewModel = guideUIState) { mainTabComponent(it, Guide) }
                        }

// 我的
                        composable(route = Profile.route,
                            exitTransition = { fadeOut(animationSpec = tween(0)) },
                            enterTransition = { fadeIn(animationSpec = tween(0)) }) { backStackEntry ->
                            val profileBackStackEntry =
                                remember(backStackEntry) { navController.getBackStackEntry(Profile.route) }
                            val profileUIState: ProfileUIState = viewModel(profileBackStackEntry)
                            ProfileScreen(modifier = Modifier.fillMaxSize(), viewModel = profileUIState) { mainTabComponent(it, Profile) }
                        }
                    }
                }
            }
        }
    }
}

fun NavHostController.navigateSingleTopTo(
    desRoute: String, curRoute: String, restore: Boolean = true
) = this.navigate(desRoute) {
    popUpTo(curRoute) { saveState = restore; inclusive = true }
    launchSingleTop = true
    restoreState = restore
}

package com.example.githubsearch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.githubsearch.presentation.Search.SearchScreen
import com.example.githubsearch.presentation.Search.SearchViewModel
import com.example.githubsearch.presentation.favorite.FavoriteScreen
import com.example.githubsearch.presentation.splash.SplashScreen
import com.example.githubsearch.presentation.userdetail.UserDetailScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Search : Screen("search")
    object Detail : Screen("detail/{itemId}") {
        fun createRoute(itemId: String) = "detail/$itemId"
    }
    object Favorite : Screen("favorite")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }
        composable(Screen.Search.route) {
            val viewModel: SearchViewModel = hiltViewModel()
            SearchScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(Screen.Detail.route) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId") ?: ""
            UserDetailScreen(navController, username = itemId)
        }
        composable(Screen.Favorite.route) {
            FavoriteScreen(
                onUserClick = { user ->
                    navController.navigate(Screen.Detail.createRoute(user.login))
                }
            )
        }
    }
}

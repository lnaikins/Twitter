package com.lizaworks.twitter

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


data class BottomNavItem<T>(val route: T, @DrawableRes val icon: Int)


@Serializable data object Home
@Serializable data object Search
@Serializable data object Messages

val bottomNavItems = listOf(
    BottomNavItem(Home, R.drawable.ic_home),
    BottomNavItem(Search, R.drawable.ic_search),
    BottomNavItem(Messages, R.drawable.ic_messages)

)


@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        bottomNavItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
            )
        }
    }
}
@Preview(device = Devices.PIXEL)
@Composable
fun NavigationHost() {
   val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = Home, Modifier.consumeWindowInsets(innerPadding)) {
            composable<Home> { ExpandedTweet() }
            composable<Search> { NFTMarketplace() }
            composable<Messages> { Profile() }

        }
    }
}


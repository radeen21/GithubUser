package com.example.githubsearch.presentation.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.githubsearch.domain.model.GithubUser
import com.example.githubsearch.domain.model.User
import com.example.githubsearch.domain.model.toDomainUser
import com.example.githubsearch.presentation.favorite.FavoriteViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    favoriteViewModel: FavoriteViewModel = hiltViewModel(),
    navController: NavHostController
) {
    var query by remember { mutableStateOf("") }
    val users by viewModel.users.collectAsState()
    val favorites by favoriteViewModel.favorites.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Search Users") },
                actions = {
                    IconButton(onClick = { navController.navigate("favorite") }) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorites"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            TextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Search GitHub User") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { viewModel.searchUser(query) }) {
                Icon(Icons.Default.Search, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Search")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(users) { user ->
                    UserItem(
                        user = user,
                        onClick = { navController.navigate("detail/${user.login}") },
                        favorites = favorites,
                        onAddFavorite = {
                            favoriteViewModel.addUser(user.toDomainUser())
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun UserItem(
    user: GithubUser,
    onClick: () -> Unit,
    favorites: List<User>,
    onAddFavorite: (User) -> Unit
) {
    val isFavorite = favorites.any { it.login == user.login }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(user.avatarUrl),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(user.login, fontWeight = FontWeight.Medium)

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onAddFavorite(user.toDomainUser()) },
            enabled = !isFavorite
        ) {
            Text(if (isFavorite) "Favorited" else "Favorite")
        }
    }
}



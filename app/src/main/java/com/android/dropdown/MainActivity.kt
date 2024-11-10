package com.android.dropdown

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.dropdown.ui.theme.DropDownTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    private val list = listOf("The Mummy 1997", "The Mummy Returns", "The Mummy 3", "Rick O'Connell (Brendan Fraser)", "Eve (Rachel We)", "Imhotep (Arnold Vosloo)", "Anck-su-namun (Patricia)",)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropDownTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = { TopAppBar() }) {
                        LazyColumn(
                            contentPadding = it,
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(10.dp)) {
                            items(list) { name ->
                                PersonItem(
                                    personName = name,
                                    dropDownItems = listOf(DropDownItem(text = "Item 1"), DropDownItem(text = "Item 2"), DropDownItem(text = "Item 3")),
                                    onItemClick = { item ->
                                        Toast.makeText(applicationContext, item.text, Toast.LENGTH_LONG).show()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


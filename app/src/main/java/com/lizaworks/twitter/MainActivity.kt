package com.lizaworks.twitter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Tab
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lizaworks.twitter.ui.theme.TwitterTheme
import kotlinx.coroutines.launch
import kotlin.text.Typography.bullet

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwitterTheme {
                NavigationHost()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    NFTMarketplace()
//                }
            }
        }
    }
}


@Composable
fun ExpandedTweet() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
//            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        TopAppBar()
        HorizontalDivider(thickness = 0.33.dp)
        YouRetweeted()
        TwitterUser()
        Tweet()
        TweetInfo()
        HorizontalDivider(thickness = 0.33.dp)
        TweetStats(numOfRetweets = 26, numOfLikes = 48)
        HorizontalDivider(thickness = 0.33.dp)
        Interact()
    }
}

@Composable
private fun TopAppBar() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(134.dp),
    ) {
        Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back")
        Text("Tweet", fontWeight = FontWeight.W800)
    }
}

@Composable
private fun YouRetweeted() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
//            .padding(horizontal = 16.dp, vertical = 8.dp),
            .padding(start = 58.dp, top = 8.dp)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.ic_retweet),
            contentDescription = "retweet",
        )
        Text("You Retweeted", color = Color(0xFF687684), fontSize = 14.sp)
    }
}

@Composable
private fun TwitterUser() {

    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pfp),
            contentDescription = "pfp",
            Modifier
                .size(55.dp)
                .clip(shape = CircleShape),
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text("Liza", fontWeight = FontWeight.W600)
                Text("@lnaikins", color = Color(0xFF687684))
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_more),
                contentDescription = "dropdown"
            )
        }

    }
}

@Composable
private fun Tweet() {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp, top = 16.dp)
    ) {
        Text("lorem ipsum jsljfdlkf;lskdffkjsdhfsjhdfjhsdkjfhsdkjfksjf")
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.tweet_image),
            contentDescription = "tweet pic",
            Modifier
                .width(366.dp)
                .height(275.dp)
        )
    }
}

@Composable
private fun TweetInfo() {
    Row() {
        Text(modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                    append("09:25 ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                    append(bullet + " ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                    append("11/20/24 ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                    append(bullet + " ")
                }
                withStyle(style = SpanStyle(color = Color(0xFF4C9EEB))) {
                    append("Twitter Web App")
                }

            })
    }
}

@Composable
private fun TweetStats(numOfRetweets: Int, numOfLikes: Int) {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp),
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.W600)) {
                append("$numOfRetweets ")
            }
            withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                append("Retweets ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.W600)) {
                append("$numOfLikes ")
            }
            withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                append("Likes")
            }
        }
    )
}

@Composable
private fun Interact() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(painter = painterResource(id = R.drawable.ic_comment), contentDescription = "comment")
        Image(painter = painterResource(id = R.drawable.ic_retweet2), contentDescription = "rt")
        Image(painter = painterResource(id = R.drawable.ic_like), contentDescription = "like")
        Image(painter = painterResource(id = R.drawable.ic_share), contentDescription = "share")
    }
}


@Composable
fun Profile() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box {

            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "header",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.ic_back2),
                contentDescription = "back",
                modifier = Modifier.padding(16.dp)

            )
            pfp(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .offset(y = 40.dp)
                    .padding(start = 16.dp)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier
                    .height(42.dp)
                    .width(133.dp)
                    .padding(end = 16.dp, top = 8.dp),
                onClick = { /*TODO*/ },
                colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.White,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White,
                ),
                border = BorderStroke(color = Color(0xFF4C9EEB), width = 1.dp)
            ) {
                Text(text = "Edit Profile", fontSize = 14.sp, color = Color(0xFF4C9EEB))
            }


        }
        Column(
            modifier = Modifier
//                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Liza",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 22.sp,
                fontWeight = FontWeight.W800
            )
            Text(
                "@lnaikins",
                modifier = Modifier.padding(horizontal = 16.dp),
                fontSize = 16.sp, color = Color(0xFF687684)
            )

            Bio()
            FollowingAndFollowers(numOfFollowing = 202, numOfFollowers = 21)

            TweetsMediaLikes()
            HorizontalDivider(thickness = 0.5.dp)
            UserLiked()
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ff_pfp),
                    contentDescription = "pfp",
                    modifier = Modifier.size(55.dp)
                )

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Row {
                        Text("Theresa ", fontWeight = FontWeight.W600)
                        Text("@theresa_adusei ", color = Color(0xFF687684))
                        Text("$bullet ", color = Color(0xFF687684))
                        Text("12h", color = Color(0xFF687684))
                    }
                    Text("This is a tweet with a link")
                    ArticleLink()
                    InteractionsInfo()

                }
            }
            NewTweetButton()
        }
    }
}

@Composable
private fun pfp(modifier: Modifier) {
    Box(
        modifier = modifier
            .border(
                width = 4.dp,
                color = Color.White,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pfp),
            contentDescription = "pfp", Modifier
                .size(68.dp)
                .clip(shape = CircleShape)
        )
    }
}

@Composable
private fun Bio() {
    Text(
        "i just want to be fed grapes",
        modifier = Modifier.padding(horizontal = 16.dp),
    )
    LinkAndDate()
}

@Composable
private fun LinkAndDate() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_link),
            contentDescription = "link"
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text("lizaaikins.com", color = Color(0xFF4C9EEB), fontSize = 14.sp)
        Spacer(modifier = Modifier.width(12.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_calendar),
            contentDescription = "calendar"
        )
        Spacer(modifier = Modifier.width(3.dp))
        Text("Joined December 2018", color = Color(0xFF687684), fontSize = 14.sp)
    }
}

@Composable
private fun FollowingAndFollowers(numOfFollowing: Int, numOfFollowers: Int) {
    Text(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),

        fontSize = 14.sp,
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.W600)) {
                append("$numOfFollowing ")
            }
            withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                append("Following   ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.W600)) {
                append("$numOfFollowers ")
            }
            withStyle(style = SpanStyle(color = Color(0xFF687684))) {
                append("Followers")
            }
        }
    )
}

@Composable
private fun TweetsMediaLikes() {
    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )
    val coroutineScope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = Color.White,
        contentColor = Color(0xFF687684),
        divider = { HorizontalDivider(thickness = 0.33.dp, color = Color(0xFF687684)) },
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                height = 2.dp,
                color = Color(0xFF4C9EEB)
            )
        }

    ) {
        Tab(selected = pagerState.currentPage == 0,
            text = {
                Text(text = "Tweets")
            },
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(0)
                }
            }
        )
        Tab(selected = pagerState.currentPage == 1,
            text = {
                Text(text = "Tweets & Replies")
            },
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(1)
                }
            }
        )
        Tab(selected = pagerState.currentPage == 2,
            text = {
                Text(text = "Media")
            },
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(2)
                }
            }
        )
        Tab(selected = pagerState.currentPage == 3,
            text = {
                Text(text = "Likes")
            },
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(3)
                }
            }
        )

    }
    HorizontalPager(state = pagerState, userScrollEnabled = false) { page ->
        Column(
            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            UserLiked()
            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ff_pfp),
                    contentDescription = "pfp",
                    modifier = Modifier.size(55.dp)
                )

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Row {
                        Text("Theresa ", fontWeight = FontWeight.W600)
                        Text("@theresa_adusei ", color = Color(0xFF687684))
                        Text("$bullet ", color = Color(0xFF687684))
                        Text("12h", color = Color(0xFF687684))
                    }
                    Text("This is a tweet with a link")
                    ArticleLink()
                    InteractionsInfo()
                }
            }

            NewTweetButton()

        }

    }
}


//@Composable
//private fun TweetsMediaLikes() {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 8.dp),
//        horizontalArrangement = Arrangement.SpaceAround
//    ) {
//        Text("Tweets", color = Color(0xFF4C9EEB), fontWeight = FontWeight.W600)
//        Text("Tweet & replies", color = Color(0xFF687684))
//        Text("Media", color = Color(0xFF687684))
//        Text("Likes", color = Color(0xFF687684))
//    }
//}

@Composable
private fun UserLiked() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_heart_solid),
            contentDescription = "liked", modifier = Modifier.padding(start = 36.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Barrack Obama liked", fontSize = 14.sp, color = Color(0xFF687684))
    }
}

@Composable
private fun ArticleLink() {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(color = Color(0xFFFFFFFF))
            .border(0.33.dp, Color(0xFFCED5DC), shape = RoundedCornerShape(12.dp))
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.unsplash_zlabb6gke24),
                contentDescription = "tweetpic",
                modifier = Modifier
                    .width(311.dp)
                    .height(160.dp)
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp
                        )
                    ),
            )
            Text(
                text = "Best Restaurants You Can Go To This Holiday",
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(
                text = "bestrestaurants.com", color = Color(0xFF687684),
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
private fun InteractionsInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

//            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_comment),
                contentDescription = "comments",
                modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "10", color = Color(0xFF687684))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_retweet2),
                contentDescription = "retweets",
                modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "22", color = Color(0xFF687684))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = "likes",
                modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "36", color = Color(0xFF687684))
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_share),
                contentDescription = "share",
                modifier = Modifier.size(15.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))

        }
    }
}

@Composable
private fun NewTweetButton() {
    Box(
        modifier = Modifier
            .offset(x = 304.dp, y = -20.dp)
            .clip(shape = RoundedCornerShape(50))
            .background(color = Color(0xFF4C9EEB))
            .size(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
//            modifier = Modifier.offset(x = -70.dp),
            painter = painterResource(id = R.drawable.ic_add_text),
            contentDescription = "add tweet"
        )
    }
}


@Composable
fun NFTMarketplace() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        MarketplaceTopAppBar()
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier
//                .height(50.dp)
                .fillMaxWidth()
                .padding(
                    start = 16.dp, end = 16.dp,
//                    bottom = 0.dp, top = 0.dp
                ),
            value = "",
            onValueChange = {},
            shape = RoundedCornerShape(34.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFE7ECF0),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Search for Marketplaces", fontSize = 16.sp)
                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Popular marketplaces",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),

                fontWeight = FontWeight.W700,
                color = Color(0xFF687684)
            )
            Image(
                modifier = Modifier.padding(start = 145.dp),
                painter = painterResource(id = R.drawable.ic_refresh),
                contentDescription = "refresh"
            )
        }
        Marketplaces()
    }
}

@Composable
private fun MarketplaceTopAppBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_left_arrow),
            contentDescription = "back"
        )
        Spacer(modifier = Modifier.width(72.dp))
        Text(text = "Connect NFT Marketplace", fontSize = 17.sp, fontWeight = FontWeight.W800)
    }
}

@Composable
private fun Marketplaces() {
    Column {


        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_open_sea),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Open Sea",
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_axie),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Axie")
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_nbatopshot),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "NBA Top Shot")
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_rarible),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Rarible")
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_super_rare),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Super Rare")
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_foundation),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Foundation")
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_nifty_gateway),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                    .size(36.5.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Nifty Gateway")
        }
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(thickness = 0.33.dp)
    }
}


@Preview(showBackground = true)
@Composable
fun ExpandedTweetPreview() {
    TwitterTheme {
        ExpandedTweet()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    TwitterTheme {
        Profile()
    }
}

@Preview(showBackground = true)
@Composable
fun NFTMarketPlacePreview() {
    TwitterTheme {
        NFTMarketplace()
    }
}
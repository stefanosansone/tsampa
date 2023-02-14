/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.tsampa.designsystem.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cookie
import androidx.compose.material.icons.filled.LocalLibrary
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material.icons.outlined.LocalLibrary
import androidx.compose.material.icons.outlined.MoreHoriz

object TsampaIcons {
    val DiaryUnselected = Icons.Outlined.LocalLibrary
    val DiarySelected = Icons.Filled.LocalLibrary
    val RecipesUnselected = Icons.Outlined.Cookie
    val RecipesSelected = Icons.Filled.Cookie
    val MoreUnselected = Icons.Outlined.MoreHoriz
    val MoreSelected = Icons.Filled.MoreHoriz
}

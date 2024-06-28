<template>
  <v-app>
    <v-app-bar app color="grey darken-1" flat>
      <v-container class="py-0 fill-height">
        <!-- 徽章 -->
        <v-badge bordered bottom color="deep-purple accent-4" dot offset-x="10" offset-y="10" >
          <v-avatar size="40">
            <v-img src="https://cdn.vuetifyjs.com/images/lists/2.jpg"></v-img>
          </v-avatar>
        </v-badge>

        <v-btn class="white--text" v-for="link in links" :key="link" text >  {{ link }} </v-btn>

        <v-spacer></v-spacer>

        <v-responsive max-width="260">
          <v-text-field
              dense
              flat
              hide-details
              rounded
              solo-inverted
          ></v-text-field>
        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-list-item
                    v-for="n in 5"
                    :key="n"
                    link
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      List Item {{ n }}
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>

                <v-list-item
                    link
                    color="grey lighten-4"
                >
                  <v-list-item-content>
                    <v-list-item-title>
                      Refresh
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-row>
              <v-col
                  v-for="card in cards"
                  :key="card"
                  cols="12"
              >
                <v-card>
                  <v-subheader>{{ card }}</v-subheader>

                  <v-list two-line>
                    <template v-for="n in 6">
                      <v-list-item

                          :key="n"
                      >
                        <v-list-item-avatar color="grey darken-1">
                        </v-list-item-avatar>

                        <v-list-item-content>
                          <v-list-item-title>Message {{ n }}</v-list-item-title>

                          <v-list-item-subtitle>
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil repellendus distinctio
                            similique
                          </v-list-item-subtitle>
                        </v-list-item-content>
                      </v-list-item>

                      <v-divider
                          v-if="n !== 6"
                          :key="`divider-${n}`"
                          inset
                      ></v-divider>
                    </template>
                  </v-list>
                </v-card>
              </v-col>
            </v-row>
          </v-col>
        </v-row>
      </v-container>
    </v-main>

    <v-footer
        dark
        padless
    >
      <v-card
          flat
          tile
          class=" grey darken-2 text-center"
      >
        <v-card-text>
          <v-btn
              v-for="icon in icons"
              :key="icon"
              class="mx-4 "
              icon
          >
            <v-icon size="24px">
              {{ icon }}
            </v-icon>
          </v-btn>
        </v-card-text>

        <v-card-text class=" pt-0">
          Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet. Mauris cursus commodo interdum. Praesent
          ut risus eget metus luctus accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a sit amet
          dui. Duis commodo vitae velit et faucibus. Morbi vehicula lacinia malesuada. Nulla placerat augue vel ipsum
          ultrices, cursus iaculis dui sollicitudin. Vestibulum eu ipsum vel diam elementum tempor vel ut orci. Orci
          varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
        </v-card-text>

        <v-divider></v-divider>

        <v-card-text class="white--text">
          {{ new Date().getFullYear() }} — <strong>Vuetify</strong>
        </v-card-text>
      </v-card>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    links: [
      'Dashboard',
      'Messages',
      'Profile',
      'Updates',
    ],
    cards: ['Today', 'Yesterday'],
    drawer: null,
    icons: [
      'mdi-facebook',
      'mdi-twitter',
      'mdi-linkedin',
      'mdi-instagram',
    ],
  }),
}
</script>

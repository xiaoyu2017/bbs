import Cookies from 'js-cookie'

// cookie存放token key
const TokenKey = 'BBS_MANAGER_TOKEN'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

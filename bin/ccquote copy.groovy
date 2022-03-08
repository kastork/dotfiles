#! /usr/bin/env groovy

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

def xlmb = 5282.7120822 + 355.2904739
def ltcb = 0.00059392
def ethb = 0.00004149
def bnbb = 0 
def btcb = 0

String key = (new File("/Users/kirk/s/.secrets/coinmarketcap")).text

def http = new HTTPBuilder('https://pro-api.coinmarketcap.com/v1/')

http.request(GET,JSON) { request ->
    headers.'X-CMC_PRO_API_KEY' = key
    headers.Accept = 'application/json'

    uri.path = 'cryptocurrency/quotes/latest'
    uri.query = [
        symbol: 'XLM,LTC,ETH,BNB,BTC'        
    ]

    response.success = { resp, json ->
        def xlm = json.data.XLM.quote.USD.price
        def ltc = json.data.LTC.quote.USD.price
        def eth = json.data.ETH.quote.USD.price
        def bnb = json.data.BNB.quote.USD.price
        def btc = json.data.BTC.quote.USD.price

        println("XLM: $xlmb\n     \$ ${xlm * xlmb}\n     \$ ${xlm} / XLM\nETH: $ethb\n     \$ ${eth * ethb}\n     \$ ${eth} / ETH\nLTC: $ltcb\n     \$ ${ltc * ltcb}\n     \$ ${ltc} / LTC\nBNB: $bnbb\n     \$ ${bnb * bnbb}\n     \$ ${bnb} / BNB\nBTC: $btcb\n     \$ ${btc * btcb}\n     \$ ${btc} / BTC" )
        println("==============================")
        println("\$ ${xlm * xlmb + eth * ethb + ltc * ltcb + bnb * bnbb}" )
     }
}

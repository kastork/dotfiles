#! /usr/bin/env groovy

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1' )
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

def xlmb = 5282.7120822
def ltcb = 0.00059392
def ethb = 0.00004149
def bnbb = 0 

String key = (new File("~/s/.secrets/coinmarketcap")).text

def http = new HTTPBuilder('https://pro-api.coinmarketcap.com/v1/')

http.request(GET,JSON) { request ->
    headers.'X-CMC_PRO_API_KEY' = key
    headers.Accept = 'application/json'

    uri.path = 'cryptocurrency/quotes/latest'
    uri.query = [
        symbol: 'XLM,LTC,ETH,BNB'        
    ]

    response.success = { resp, json ->
        def xlm = json.data.XLM.quote.USD.price
        def ltc = json.data.LTC.quote.USD.price
        def eth = json.data.ETH.quote.USD.price
        def bnb = json.data.BNB.quote.USD.price

        println("XLM: $xlmb\n     \$ ${xlm * xlmb}\n     \$ ${xlm} / XLM\nETH: $ethb\n     \$ ${eth * ethb}\n     \$ ${eth} / ETH\nLTC: $ltcb\n     \$ ${ltc * ltcb}\n     \$ ${ltc} / LTC\nBNB: $bnbb\n     \$ ${bnb * bnbb}\n     \$ ${bnb} / BNB" )
        println("==============================")
        println("\$ ${xlm * xlmb + eth * ethb + ltc * ltcb + bnb * bnbb}" )
     }
}

/*
{
    "status": {
        "timestamp": "2018-10-08T13:02:41.447Z",
        "error_code": 0,
        "error_message": null,
        "elapsed": 13,
        "credit_count": 1
    },
    "data": {
        "BNB": {
            "id": 1839,
            "name": "Binance Coin",
            "symbol": "BNB",
            "slug": "binance-coin",
            "circulating_supply": 117443301,
            "total_supply": 192443301,
            "max_supply": null,
            "date_added": "2017-07-25T00:00:00.000Z",
            "num_market_pairs": 95,
            "cmc_rank": 14,
            "last_updated": "2018-10-08T13:01:33.000Z",
            "quote": {
                "USD": {
                    "price": 10.5693200302,
                    "volume_24h": 35529385.2440961,
                    "percent_change_1h": 0.144368,
                    "percent_change_24h": 1.66196,
                    "percent_change_7d": 6.39257,
                    "market_cap": 1241295833.6721077,
                    "last_updated": "2018-10-08T13:01:33.000Z"
                }
            }
        },
        "ETH": {
            "id": 1027,
            "name": "Ethereum",
            "symbol": "ETH",
            "slug": "ethereum",
            "circulating_supply": 102442824.7803,
            "total_supply": 102442824.7803,
            "max_supply": null,
            "date_added": "2015-08-07T00:00:00.000Z",
            "num_market_pairs": 4403,
            "cmc_rank": 2,
            "last_updated": "2018-10-08T13:01:43.000Z",
            "quote": {
                "USD": {
                    "price": 229.280374356,
                    "volume_24h": 1501831652.99828,
                    "percent_change_1h": 1.32543,
                    "percent_change_24h": 2.58198,
                    "percent_change_7d": -0.127556,
                    "market_cap": 23488129215.7133,
                    "last_updated": "2018-10-08T13:01:43.000Z"
                }
            }
        },
        "LTC": {
            "id": 2,
            "name": "Litecoin",
            "symbol": "LTC",
            "slug": "litecoin",
            "circulating_supply": 58633627.1201553,
            "total_supply": 58633627.1201553,
            "max_supply": 84000000,
            "date_added": "2013-04-28T00:00:00.000Z",
            "num_market_pairs": 576,
            "cmc_rank": 7,
            "last_updated": "2018-10-08T13:02:05.000Z",
            "quote": {
                "USD": {
                    "price": 59.2479110464,
                    "volume_24h": 285848374.387926,
                    "percent_change_1h": 1.94069,
                    "percent_change_24h": 2.04961,
                    "percent_change_7d": -2.01022,
                    "market_cap": 3473919923.9427476,
                    "last_updated": "2018-10-08T13:02:05.000Z"
                }
            }
        },
        "XLM": {
            "id": 512,
            "name": "Stellar",
            "symbol": "XLM",
            "slug": "stellar",
            "circulating_supply": 18806826278.0372,
            "total_supply": 104343717210.401,
            "max_supply": null,
            "date_added": "2014-08-05T00:00:00.000Z",
            "num_market_pairs": 120,
            "cmc_rank": 6,
            "last_updated": "2018-10-08T13:01:25.000Z",
            "quote": {
                "USD": {
                    "price": 0.246008708517,
                    "volume_24h": 37623577.1557787,
                    "percent_change_1h": 0.228375,
                    "percent_change_24h": 2.79854,
                    "percent_change_7d": -5.081,
                    "market_cap": 4626643043.96351,
                    "last_updated": "2018-10-08T13:01:25.000Z"
                }
            }
        }
    }
}

*/

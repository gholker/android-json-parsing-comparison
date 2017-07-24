Android Json Parsing Comparison
-------------------------------

#### Summary

I compared popular JSON parsing libraries: GSON, Moshi, and Jackson using both POJOs and AutoValue. 

##### Performance

The performance comparison does not show strong differentiation, but GSON tends to lag behind Jackson and Moshi. 

Jackson with AutoValue performed better than with POJOs. I suspect this is because I specified the field mappings with @JsonProperty.

##### Qualitative

The APIs are all similar with POJOs. 
AutoValue requires more manual wrangling for each to work.

Moshi requires [adapters](app/src/main/com/grahamholker/json/autovalue/moshi/Story.java#L77-L79) for each of the types and an [AdapterFactory](app/src/main/com/grahamholker/json/autovalue/moshi/MyAdapterFactory.java).
There is a library that generates them for you and setting it up is straight-forward.
It's straight-forward to create your own adapter in place of the auto generated one if necessary. 

Gson requires an [AdapterFactory](app/src/main/com/grahamholker/json/autovalue/gson/AutoValueAdapterFactory.java) as well. 
There is no library, but there is an example [gist](https://gist.github.com/JakeWharton/0d67d01badcee0ae7bc9).

Jackson requires an annotation on each class and on each field. 
On the class you need to specify the deserializer (`@JsonDeserialize(builder = AutoValue_Story.Builder.class)`).
On the fields the JSON property name (`@JsonProperty("name")`).

#### Further work

- Test on more devices
- Test with more iterations and see how iterations affect performance
- Test with larger payloads

#### Results


| Name              | Average (ms)  | Max (ms)  | Min (ms)  | Total |
|-------------------|---------------| ----------|-----------|-------|
| AutoGson read	    | 47.3          | 127       | 35        |       |
| AutoGson write    | 73.9	        | 145	    | 57        |       |
|                   | 121.2	        | 272	    | 92	    | 485.2 |
| GSON read	        | 42.9	        | 130	    | 30        |       |
| GSON write	    | 70.6          | 143	    | 58        |       |
|                   | 113.5	        | 273	    | 88	    | 474.5 |
| Moshi read	    | 52.6	        | 166	    | 35        |       |
| Moshi write	    | 34.7	        | 97	    | 26        |       |
|                   | 87.3	        | 263	    | 61        | 411.3 |
| AutoMoshi read	| 52.7	        | 174	    | 34        |       |
| AutoMoshi write	| 33.1	        | 89	    | 25        |       |
|                   | 85.8	        | 263	    | 59	    | 407.8 |
| AutoJackson read	| 80.8	        | 264	    | 47        |       |
| AutoJackson write	| 3             | 18        | 1         |       |
|                   | 83.8	        | 282	    | 48	    | 413.8 |
| Jackson read	    | 50            | 210	    | 27        |       |
| Jackson write	    | 39.9	        | 154	    | 21        |       |
|                   | 89.9	        | 364	    | 48        | 501.9 |

Results taken from reading and writing 157K in memory 10 times on a Samsung Note 4 (Snapdragon) running LineageOS 7.1. 

I chose 10 iterations because it seemed representative of app usage. 


#### References

[AutoValue](https://github.com/google/auto)
[Moshi](https://github.com/square/moshi)
[AutoValue Moshi lib](https://github.com/rharter/auto-value-moshi)
[AutoJackson Examples](https://github.com/artem-zinnatullin/AutoJackson)
[AutoGson setup](https://gist.github.com/JakeWharton/0d67d01badcee0ae7bc9)


	


	
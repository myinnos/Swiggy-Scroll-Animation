# Swiggy Offer Scroll Animation

 ![Swiggy Offer Scroll Animation - Example](https://raw.githubusercontent.com/myinnos/Swiggy-Scroll-Animation/master/gif/demo.gif)

#### Download Demo APK from [HERE](https://github.com/myinnos/Swiggy-Scroll-Animation/blob/master/apk/app-debug.apk "APK")

#### Use the following code for the awesome animation:

To build this animation used RecyclerView as it has a OnScrollListener. [Ref.](https://github.com/myinnos/Swiggy-Scroll-Animation/blob/master/app/src/main/java/in/myinnos/swiggyanimation/MainActivity.java "File")

```java
recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                adpater.recyclerViewScrolled(recyclerView, dy);
            }
        });
```

In the callback onScrolled() we notify the adapter using a custom method recyclerViewScrolled()and pass the reference of the view and the amount of vertical scroll.

After the adapter is notified, it is his responsibility to get the view holders for all the items and rotate the image view. Let’s see how can this be done. [Ref.](https://github.com/myinnos/Swiggy-Scroll-Animation/blob/master/app/src/main/java/in/myinnos/swiggyanimation/RecyclerAdapter.java "File")

```java
void recyclerViewScrolled(RecyclerView recyclerView, int scrollAmount) {

        RecyclerAdapter.ViewHolder holder = null;

        int starPos = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        int lastPos = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();

        if (starPos <= lastPos) {
            while (true) {
                holder = (RecyclerAdapter.ViewHolder) recyclerView.findViewHolderForLayoutPosition(starPos);
                if (holder != null) {
                    holder.imOffer.setRotation(holder.imOffer.getRotation() + (float) scrollAmount);
                }
                if (starPos == lastPos) {
                    break;
                }
                ++starPos;
            }
        }
    }
```
#### That's it your awesome animation ready

##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/Swiggy-Scroll-Animation/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on twitter")   
* :camera: Instagram: [@prabhakar_t_](https://www.instagram.com/prabhakar_t_/ "Prabhakar Thota on Instagram")   

License
-------

    Copyright 2019 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


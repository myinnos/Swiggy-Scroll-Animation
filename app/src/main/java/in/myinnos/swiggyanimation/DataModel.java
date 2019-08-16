package in.myinnos.swiggyanimation;

class DataModel {

    private String title;
    private String category;
    private String offer;

    DataModel(String title, String category, String offer) {
        this.title = title;
        this.category = category;
        this.offer = offer;
    }

    String getTitle() {
        return title;
    }

    String getCategory() {
        return category;
    }

    String getOffer() {
        return offer;
    }
}

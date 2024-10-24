package com.eco.ecomarket.Model.AirPollution;
import java.util.List;
public class PollutionData {

        private Coord coord;
        private List<Pollution> list;

        public PollutionData(Coord coord, List<Pollution> list) {
            this.coord = coord;
            this.list = list;
        }

        public Coord getCoord() {
            return coord;
        }

        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        public List<Pollution> getList() {
            return list;
        }

        public void setList(List<Pollution> list) {
            this.list = list;
        }
    }



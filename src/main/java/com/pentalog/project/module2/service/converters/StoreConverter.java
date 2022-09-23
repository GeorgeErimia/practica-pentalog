package com.pentalog.project.module2.service.converters;

import com.pentalog.project.module2.model.dtos.StoreDto;
import com.pentalog.project.module2.repository.store.Store;

import java.util.List;

public class StoreConverter {

        public static StoreDto toDto(Store store) {

            return new StoreDto()
                    .setName(store.getName())
                    .setLocation(store.getLocation())
                    .setWebsite(store.getWebsite())
                    .setGames(GameConverter.toDto(store.getGames()));
        }

        public static Store toEntity(StoreDto storeDto) {

            return new Store()
                    .setName(storeDto.getName())
                    .setLocation(storeDto.getLocation())
                    .setWebsite(storeDto.getWebsite())
                    .setGames(GameConverter.toEntity(storeDto.getGames()));
        }

        public static List<StoreDto> toDto(List<Store> stores){
            return stores.stream().map(StoreConverter::toDto).toList();
        }

        public static List<Store> toEntity(List<StoreDto> storeDtos){
            return storeDtos.stream().map(StoreConverter::toEntity).toList();
        }
}

package generic

open class BaseBuildingMaterial() {
    open val numberNeeded: Int = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded: Int = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded: Int = 8
}

class Building<out T : BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 100
    var actualMaterialsNeeded: Int = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("type:${buildingMaterial::class.simpleName}, number of materials needed : " +
                "$actualMaterialsNeeded")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) =
        if (building.actualMaterialsNeeded < 500)
            println("small building")
        else
            println("large building")

fun main(args: Array<String>) {
    val wood = Wood()
    val building = Building(wood)
    building.build()

    isSmallBuilding(building)
}
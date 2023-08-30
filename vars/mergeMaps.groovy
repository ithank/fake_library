import com.ops.mapMerge

def call(Map... maps){
    def mm =  new mapMerge()
    return mm.merge(maps)
}
